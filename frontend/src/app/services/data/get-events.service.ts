import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppSettings} from '../../constants/AppSettings';

@Injectable({
  providedIn: 'root'
})
export class GetEventsService {

  constructor(private http: HttpClient) { }

  getEvents() {
    return this.http.get(AppSettings.BACKEND_URL + "/events/orderd");
  }
}
