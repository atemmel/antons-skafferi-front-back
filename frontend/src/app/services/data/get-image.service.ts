import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppSettings } from '../../constants/AppSettings';

@Injectable({
  providedIn: 'root'
})
export class GetImageService {


  /*constructor(private http: HttpClient) { }

  // Sends Http request to backend for a specific image
  getImage(folderName: string, name: string) {
    console.log(AppSettings.BACKEND_URL + AppSettings.IMAGES_PATH + 'folder=' + folderName + '&image=' + name)
    return this.http.get(AppSettings.BACKEND_URL + AppSettings.IMAGES_PATH + 'folder=' + folderName + '&image=' + name, {
      responseType: 'text'
   });
  }*/


}
