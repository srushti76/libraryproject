import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { ErrorComponent } from './error/error.component';
import { ListOfBooksComponent } from './list-of-books/list-of-books.component';
import { MenuComponent } from './menu/menu.component';
import { FooterComponent } from './footer/footer.component';
import { LogoutComponent } from './logout/logout.component';
import { RegisterComponent } from './register/register.component';
import { UploadbookComponent } from './uploadbook/uploadbook.component';
import { HttpClientModule } from '@angular/common/http';
import { UploadedBooksComponent } from './uploaded-books/uploaded-books.component';

import { RequestsentComponent } from './requestsent/requestsent.component';
import { RequestreceivedComponent } from './requestreceived/requestreceived.component';
import { BorrowedbooksComponent } from './borrowedbooks/borrowedbooks.component';
import { UserdetailComponent } from './userdetail/userdetail.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    WelcomeComponent,
    ErrorComponent,
    ListOfBooksComponent,
    MenuComponent,
    FooterComponent,
    LogoutComponent,
    RegisterComponent,
    UploadbookComponent,
    UploadedBooksComponent,
    RequestsentComponent,
    RequestreceivedComponent,
    BorrowedbooksComponent,
    UserdetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
