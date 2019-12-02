import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppSettings} from '../../constants/AppSettings';

@Injectable({
  providedIn: 'root'
})
export class GetItemsService {

  constructor(private http: HttpClient) { }

  getItems() {
    return this.http.get(AppSettings.BACKEND_URL + "/items");
  }
}
