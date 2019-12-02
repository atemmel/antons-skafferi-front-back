import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {AppSettings} from '../../constants/AppSettings';
import {DomSanitizer} from '@angular/platform-browser';

@Injectable({
  providedIn: 'root'
})
export class GetCategoriesService {


  constructor(private http: HttpClient, private sanitizer: DomSanitizer) { }

  getCategories() {
    return this.http.get(AppSettings.BACKEND_URL + "/itemcategorys");
  }
}
