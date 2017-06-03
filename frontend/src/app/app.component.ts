import { Component, ViewEncapsulation } from '@angular/core';

require('!!style-loader!css-loader!sass-loader!../styles.scss');  

@Component({
    moduleId: module.id.toString(),
    selector: 'app',
    templateUrl: 'app.component.html',
    //styles: [ require('./app.component.scss') ]
    //encapsulation: ViewEncapsulation.None
})

export class AppComponent { }