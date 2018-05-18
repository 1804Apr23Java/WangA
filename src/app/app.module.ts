import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { Router } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './homepage/homepage.component';
import { HonoluluComponent } from './honolulu/honolulu.component';
import { NavComponent } from './nav/nav.component';
import { MiamiComponent } from './miami/miami.component';
import { LosangelesComponent } from './losangeles/losangeles.component';
import { HttpComponent } from './http/http.component';
import { FormdataService } from './services/formdata.service';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    HonoluluComponent,
    NavComponent,
    MiamiComponent,
    LosangelesComponent,
    HttpComponent
  ],
  imports: [ 
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpModule
  ],
  providers: [FormdataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
