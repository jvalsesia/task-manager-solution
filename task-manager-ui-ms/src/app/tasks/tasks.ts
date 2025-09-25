import { Component, computed, inject, input, OnInit } from '@angular/core';
import { Task } from '../task/task';
import { TasksService } from '../service/tasks-service';
import { Newtask } from '../newtask/newtask';
import { TaskDto, TaskPayload } from '../task/task.model';

@Component({
  selector: 'app-tasks',
  imports: [Task, Newtask],
  templateUrl: './tasks.html',
  styleUrl: './tasks.css'
})
export class Tasks implements OnInit {
  private tasksService = inject(TasksService);
  isAddingTask = false;

  ngOnInit(): void {
    this.tasksService.listTasks();
  }

  getTasks = computed(() => this.tasksService.tasks() || []);


  onStartAddTask() {
    this.isAddingTask = true;
  }

  onCancelAddTask() {
    this.isAddingTask = false;
  }

  onAddTask(taskPayload: TaskPayload) {
    this.isAddingTask = false;
    this.tasksService.createTask(taskPayload);
    this.getTasks
  }
}
