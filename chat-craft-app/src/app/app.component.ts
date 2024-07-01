import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PromptComponent } from './components/prompt/prompt.component';
import { AppDisplayComponent } from './components/app-display/app-display.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, PromptComponent, AppDisplayComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'chat-craft-app';
  appUrl: string | null = null;

  onPromptSubmitted(prompt: string) {
    // Call the backend service to generate the app URL and set it
    this.appUrl = `Generated URL for the prompt: ${prompt}`;
  }
}
