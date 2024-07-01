import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OpenAIService {
  private apiUrl = 'YOUR_BACKEND_API_URL';

  constructor(private http: HttpClient) { }

  generateCode(prompt: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/generate`, { prompt });
  }
}
