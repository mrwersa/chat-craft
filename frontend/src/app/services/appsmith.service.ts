import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppsmithService {
  private apiUrl = 'http://localhost:8080/api/generate'; // Replace with your backend API endpoint

  constructor(private http: HttpClient) { }

  generateApp(prompt: string): Observable<any> {
    const body = { prompt };
    return this.http.post<any>(this.apiUrl, body);
  }
}
