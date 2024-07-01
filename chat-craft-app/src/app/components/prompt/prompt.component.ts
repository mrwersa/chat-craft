import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AppsmithService } from '../../services/appsmith.service';
import { catchError, of, tap } from 'rxjs';

@Component({
  selector: 'app-prompt',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './prompt.component.html',
  styleUrls: ['./prompt.component.scss']
})
export class PromptComponent {
  promptForm: FormGroup;
  @Output() promptSubmitted = new EventEmitter<string>();

  constructor(private fb: FormBuilder, private appsmithService: AppsmithService) {
    this.promptForm = this.fb.group({
      prompt: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.promptForm.valid) {
      const prompt = this.promptForm.value.prompt;
      this.appsmithService.generateApp(prompt).pipe(
        tap(response => {
          this.promptSubmitted.emit(response.appUrl); // Assuming the response contains `appUrl`
        }),
        catchError(error => {
          console.error('Error generating app:', error);
          return of(null); // Handle the error and return a fallback value
        })
      ).subscribe();
    }
  }
}
