import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppSettings } from '../../constants/AppSettings';

@Injectable({
  providedIn: 'root'
})
export class GetImageService {


  constructor(private http: HttpClient) { }

  // Sends Http request to backend for a specific image
  getImage(folderName: string) {
    return this.http.get(AppSettings.BACKEND_URL + '/images?path=' + folderName, {
      responseType: 'text'
   });
  }


}
