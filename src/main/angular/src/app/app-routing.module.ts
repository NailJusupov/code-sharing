import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MainPageComponent} from './main-page/main-page.component';
import {AddGistPageComponent} from './add-gist-page/add-gist-page.component';
import {GistViewComponent} from './gist-view/gist-view.component';


const routes: Routes = [
  {path: '', component: MainPageComponent},
  {path: 'add-gist', component: AddGistPageComponent},
  {path: 'gist/:id', component: GistViewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
