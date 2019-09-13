import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserMenuComponent } from './user-menu/user-menu.component';
import { MainPageComponent } from './main-page/main-page.component';
import { MainHeaderComponent } from './main-header/main-header.component';
import { UserAuthenticationFormComponent } from './user-authentification-form/user-authentication-form.component';
import { UserRegistrationFormComponent } from './user-registration-form/user-registration-form.component';
import { StyledInputComponent } from './styled-input/styled-input.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { CodeShortInfoCardComponent } from './code-short-info-card/code-short-info-card.component';
import { AddGistPageComponent } from './add-gist-page/add-gist-page.component';
import { CodeEditorComponent } from './code-editor/code-editor.component';
import { MainPageToolBarComponent } from './main-page-tool-bar/main-page-tool-bar.component';
import { GistViewComponent } from './gist-view/gist-view.component';
import { StarsCountComponent } from './stars-count/stars-count.component';
import { PagesSwitchButtonsComponent } from './pages-switch-buttons/pages-switch-buttons.component';
import { SearchInputComponent } from './search-input/search-input.component';
import { UserGistsPageComponent } from './user-gists-page/user-gists-page.component';

@NgModule({
  declarations: [
    AppComponent,
    UserMenuComponent,
    MainPageComponent,
    MainHeaderComponent,
    UserAuthenticationFormComponent,
    UserRegistrationFormComponent,
    StyledInputComponent,
    CodeShortInfoCardComponent,
    AddGistPageComponent,
    CodeEditorComponent,
    MainPageToolBarComponent,
    GistViewComponent,
    StarsCountComponent,
    PagesSwitchButtonsComponent,
    SearchInputComponent,
    UserGistsPageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    { provide: "BASE_API_URL", useValue: 'http://localhost:8080/api' }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
