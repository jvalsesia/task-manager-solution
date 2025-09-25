import { Component, computed, inject, OnInit } from '@angular/core';
import { Task } from '../task/task';
import { TasksService } from '../service/tasks-service';

@Component({
  selector: 'app-tasks',
  imports: [Task],
  templateUrl: './tasks.html',
  styleUrl: './tasks.css'
})
export class Tasks implements OnInit {
  private tasksService = inject(TasksService);

  ngOnInit(): void {
    this.tasksService.listTasks();
  }

  getTasks = computed(() => this.tasksService.tasks() || []);
}
