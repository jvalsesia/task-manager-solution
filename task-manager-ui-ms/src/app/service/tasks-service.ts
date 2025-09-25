import { Injectable, computed, inject, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CompleteDto, TaskDto } from '../task/task.model';

@Injectable({
  providedIn: 'root'
})
export class TasksService {
  private readonly apiUrl = 'http://localhost:8080/api';
  private httpClient = inject(HttpClient);

  // Create a private signal for internal state management
  private tasksSignal = signal<TaskDto[]>([]);

  // Public getter for the tasks signal
  // get tasks() {
  //     return this.tasksSignal.asReadonly();
  // }
  tasks = computed(() => this.tasksSignal());

  listTasks(): void {
    this.httpClient.get<TaskDto[]>(`${this.apiUrl}/list`).subscribe({
      next: (data) => {
        this.tasksSignal.set(data);
        console.log('Tasks fetched successfully:', data);
      },
      error: (error) => {
        console.error('Error fetching tasks:', error);
      }
    });
  }

  completeTask(id: string, completed: boolean): void {

    if (completed) {
      this.httpClient.patch<CompleteDto>(`${this.apiUrl}/complete`, null, { params: { id } }).subscribe({
        next: (completeDto) => {
          if (completeDto.taskfound) {
            // Update the local signal to reflect the completed status
            const updatedTasks = this.tasksSignal().map(task =>
              task.id === id ? { ...task, completed: completeDto.completed } : task
            );
            this.tasksSignal.set(updatedTasks);
            console.log(`Task with id ${id} marked as completed.`);
          } else {
            console.warn(`Task with id ${id} not found.`);
          }
        },
        error: (error) => {
          console.error('Error completing task:', error);
        }
      });
    } else {
      this.httpClient.patch<CompleteDto>(`${this.apiUrl}/uncomplete`, null, { params: { id } }).subscribe({
        next: (completeDto) => {
          if (completeDto.taskfound) {
            // Update the local signal to reflect the uncompleted status
            const updatedTasks = this.tasksSignal().map(task =>
              task.id === id ? { ...task, completed: completeDto.completed } : task
            );
            this.tasksSignal.set(updatedTasks);
            console.log(`Task with id ${id} marked as uncompleted.`);
          } else {
            console.warn(`Task with id ${id} not found.`);
          }
        },
        error: (error) => {
          console.error('Error uncompleting task:', error);
        }
      });

    }



  }



  deleteTask(id: string): void {
    this.httpClient.delete<boolean>(`${this.apiUrl}/delete`, { params: { id } }).subscribe({
      next: (deleted) => {
        if (deleted) {
          // Update the local signal to remove the deleted task
          const updatedTasks = this.tasksSignal().filter(task => task.id !== id);
          this.tasksSignal.set(updatedTasks);
          console.log(`Task with id ${id} deleted successfully.`);
        } else {
          console.warn(`Task with id ${id} could not be deleted.`);
        }
      },
      error: (error) => {
        console.error('Error deleting task:', error);
      }
    });
  }
}   
