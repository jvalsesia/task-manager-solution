import { Component, inject, input } from '@angular/core';
import { TasksService } from '../service/tasks-service';
import { TaskDto } from './task.model';

@Component({
  selector: 'app-task',
  imports: [],
  templateUrl: './task.html',
  styleUrl: './task.css'
})
export class Task {
  private tasksService = inject(TasksService);
  taskData = input.required<TaskDto>();

  onCompleteTask() {
    this.tasksService.completeTask(this.taskData().id, true);
  }

  onUncompleteTask() {
    this.tasksService.completeTask(this.taskData().id, false);
  }

  onDeleteTask() {
    this.tasksService.deleteTask(this.taskData().id);
  }

}
