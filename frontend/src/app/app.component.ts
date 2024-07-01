import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { PromptComponent } from './components/prompt/prompt.component';
import { AppDisplayComponent } from './components/app-display/app-display.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, PromptComponent, AppDisplayComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'chat-craft-app';
  appUrl: string | null = null;
  sidebarVisible: boolean = true;

  onPromptSubmitted(appUrl: string) {
    this.appUrl = appUrl;
  }

  toggleSidebar() {
    this.sidebarVisible = !this.sidebarVisible;
  }
}
