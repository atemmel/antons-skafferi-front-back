import { Component, OnInit } from '@angular/core';
import { GetImageService } from '../services/data/get-image.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})

export class NavbarComponent implements OnInit{
  image: any;
  imageName: string = 'AntonsLogo.png';
  folderName: string = 'website';
  constructor(private service: GetImageService, private sanitizer: DomSanitizer) { }

  ngOnInit() {
    this.getLogo();
  }

  getLogo(){
    this.service.getImage(this.folderName, this.imageName).subscribe(response=>{
      this.image = this.sanitizer.bypassSecurityTrustResourceUrl('data:image/png;base64,'+response);
    }, error=>{
      console.log(error);
    });
  }

}
