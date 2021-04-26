import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardParticipantComponent } from './board-participant/board-participant.component';
import { BoardConcepteurComponent } from './board-concepteur/board-concepteur.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import {CreerQuestionComponent} from './creer-question/creer-question.component';
import {CreerQuizzComponent} from './creer-quizz/creer-quizz.component';
import {CreerCompetenceComponent} from './creer-competence/creer-competence.component';
import {ListeCompetenceComponent} from './liste-competence/liste-competence.component';
import { QuizzComponent } from './quizz/quizz.component';
import { DoQuizzComponent } from './do-quizz/do-quizz.component';
import { QuestionsComponent } from './questions/questions.component';
import { UserListComponent } from './user-list/user-list.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UserDetailsComponent } from './user-details/user-details.component';



const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'participant', component: BoardParticipantComponent },
  { path: 'concepteur', component: BoardConcepteurComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: 'creer-competence', component: CreerCompetenceComponent },
  { path: 'creer-question', component: CreerQuestionComponent },
  { path: 'creer-quizz', component: CreerQuizzComponent },
  { path: 'liste-competence', component: ListeCompetenceComponent },
  { path: 'quizz', component: QuizzComponent },
  { path: 'doquizz/:id', component: DoQuizzComponent },
  { path: 'questions', component: QuestionsComponent },
  { path: 'users', component: UserListComponent },
  { path: 'createUser', component: CreateUserComponent },
  { path: 'user/:id', component: UserDetailsComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
