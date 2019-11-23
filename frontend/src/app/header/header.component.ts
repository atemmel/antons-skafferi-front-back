import { Component, OnInit } from '@angular/core';
import { GetImageService } from '../services/data/get-image.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  image: any;
  imageBase64: any;
  newStyle = 'background-image: url("data:image/jpg;base64,' + this.image + '")';
  imageName: string = 'restaurant_1920x1280.jpg';
  folderName: string = 'website';
  constructor(private service: GetImageService, private sanitizer: DomSanitizer) { }


  ngOnInit() {
    this.getHeaderImage();
  }

  getHeaderImage() {
    this.service.getImage(this.folderName, this.imageName).subscribe(data => {
      // Tells angular that the link and the data is safe.

	  //Sanitize resources (works with img sources)
      this.image = this.sanitizer.bypassSecurityTrustResourceUrl('data:image/jpg;base64,' + data);
     // console.log(this.image.changingThisBreaksApplicationSecurity)
    //Sanitize styles
      let test:string = this.image.changingThisBreaksApplicationSecurity;
      console.log(test);
      this.image = this.sanitizer.bypassSecurityTrustStyle('url("' + test + '")');
      console.log(this.image)
    }, error => {
    console.log(error);
    });
  }

}
