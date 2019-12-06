import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppSettings} from '../../constants/AppSettings';

@Injectable({
  providedIn: 'root'
})
export class GetTabelsService {

  constructor(private http: HttpClient) { }

  getTabels(date: string) {
    return this.http.get(AppSettings.BACKEND_URL + "/dinnertables/booking?date=" + date);
  }

}
