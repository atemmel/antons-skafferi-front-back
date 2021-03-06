import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {AppSettings} from '../../constants/AppSettings';

@Injectable({
  providedIn: 'root'
})
export class GetCategoriesService {


  constructor(private http: HttpClient) { }

  getCategories() {
    return this.http.get(AppSettings.BACKEND_URL + "/itemcategorys");
  }
}
