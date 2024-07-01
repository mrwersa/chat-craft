import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-app-display',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app-display.component.html',
  styleUrls: ['./app-display.component.scss']
})
export class AppDisplayComponent {
  @Input() appUrl: string | null = null;
  loading: boolean = false;

  ngOnInit(): void {
    if (this.appUrl) {
      this.loading = false;
    }
  }

  // Add method to update the loading state
  setLoading(isLoading: boolean): void {
    this.loading = isLoading;
  }
}
