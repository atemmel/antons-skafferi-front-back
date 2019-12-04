import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { AppSettings } from '../../constants/AppSettings';

@Injectable({
  providedIn: 'root'
})
export class GetLunchesService {


  constructor(private http: HttpClient) { }

  getLunches() {
    return this.http.get(AppSettings.BACKEND_URL + "/lunches");
  }
}
