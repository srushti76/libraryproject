import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { ErrorComponent } from './error/error.component';
import { ListOfBooksComponent } from './list-of-books/list-of-books.component';
import { LogoutComponent } from './logout/logout.component';
import { RouteGuardService } from './service/route-guard.service';
import { RegisterComponent } from './register/register.component';
import { UploadbookComponent } from './uploadbook/uploadbook.component';
import { UploadedBooksComponent } from './uploaded-books/uploaded-books.component';
import { RequestsentComponent } from './requestsent/requestsent.component';
import { RequestreceivedComponent } from './requestreceived/requestreceived.component';
import { BorrowedbooksComponent } from './borrowedbooks/borrowedbooks.component';
import { UserdetailComponent } from './userdetail/userdetail.component';


const routes: Routes = [
  {path: '', component: LoginComponent }, //canActivate, RouteGaurdService
  {path: 'login', component:LoginComponent},
  {path: 'register', component:RegisterComponent},
  {path: 'welcome', component:WelcomeComponent},
  {path: 'listOfBooks', component:ListOfBooksComponent},
  {path: 'uploadbook', component:UploadbookComponent},
  {path: 'uploadedbooks', component:UploadedBooksComponent},
  {path: 'borrowedbooks', component:BorrowedbooksComponent},
  {path: 'requestsent', component:RequestsentComponent},
  {path: 'userdetails', component:UserdetailComponent},
  {path: 'requestreceived', component:RequestreceivedComponent},
  {path: 'logout', component:LogoutComponent},
  {path: '**', component:ErrorComponent}

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
