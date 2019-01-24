import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { HomeComponent } from "./component/home/home.component";
import { NavBarComponent } from "./component/nav-bar/nav-bar.component";
import { SearchComponent } from "./component/search/search.component";
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import { BookComponent } from './component/book/book.component';

@NgModule({
  declarations: [AppComponent, HomeComponent, NavBarComponent, SearchComponent, BookComponent],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
