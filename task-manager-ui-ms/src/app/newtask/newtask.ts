import { Component, output, signal } from '@angular/core';
import { FormControl, FormGroup, FormsModule, Validators } from '@angular/forms';
import { type TaskPayload } from '../task/task.model';
import { ReactiveFormsModule } from '@angular/forms';
@Component({
  selector: 'app-newtask',
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './newtask.html',
  styleUrl: './newtask.css'
})
export class Newtask {
  cancel = output<void>();
  addTask = output<TaskPayload>();

  enteredTitle = signal('');
  enteredDescription = signal('');
  initComplted = signal(false);


  // Define the FormGroup
  taskForm = new FormGroup({
    // 'title' is required and must be at least 4 characters
    title: new FormControl('', [
      Validators.required
    ]),
    // 'description' is required and must match the email pattern
    description: new FormControl('', [
      Validators.required
    ]),
  });

  onCancel() {
    this.cancel.emit();
  }

  onSubmit() {
    console.log(this.enteredTitle());
    console.log(this.enteredDescription());
    console.log(this.initComplted());
    this.addTask.emit({
      title: this.enteredTitle(),
      description: this.enteredDescription(),
      completed: this.initComplted()
    });
  }


}

