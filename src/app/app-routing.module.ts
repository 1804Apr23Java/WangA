import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

// Components
import { HomepageComponent } from './homepage/homepage.component';
import { HonoluluComponent } from './honolulu/honolulu.component';
import { MiamiComponent } from './miami/miami.component';
import { LosangelesComponent } from './losangeles/losangeles.component';

export const routes: Routes = [
    { path: '', redirectTo: '/homepage', pathMatch: 'full' },
    { path: 'homepage',  component: HomepageComponent },
    { path: 'honolulu', component: HonoluluComponent },
    { path: 'miami', component: MiamiComponent },
    { path: 'losangeles', component: LosangelesComponent },
    { path: '**', redirectTo: '/homepage' }
]

@NgModule({
    imports: [ RouterModule.forRoot(routes, {useHash: true}) ],
    exports: [ RouterModule ]
   })
export class AppRoutingModule {}