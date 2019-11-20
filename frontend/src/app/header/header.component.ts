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
  test:boolean = true;

  imageName: string = "restaurant_1280x853";
  folderName: string = "website";
  constructor(private service: GetImageService, private sanitizer: DomSanitizer) { }

  
  ngOnInit() {
    this.getHeaderImage();
  }

  getHeaderImage(){
    this.service.getImage(this.folderName, this.imageName).subscribe(data => {
      //Tells angular that the link and the data is safe.
      this.image = this.sanitizer.bypassSecurityTrustResourceUrl('data:image/jpg;base64,' + data);
    
    }, error=>{
    console.log(error);
    });
  }

}
