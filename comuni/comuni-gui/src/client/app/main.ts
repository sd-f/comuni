import { APP_BASE_HREF } from '@angular/common';
import { disableDeprecatedForms, provideForms } from '@angular/forms';
import { enableProdMode } from '@angular/core';
import { bootstrap } from '@angular/platform-browser-dynamic';
import { MdIconRegistry} from '@angular2-material/icon/icon';

import { APP_ROUTER_PROVIDERS } from './app.routes';
import { AppComponent } from './app.component';

if ('<%= ENV %>' === 'prod') { enableProdMode(); }

bootstrap(AppComponent, [
  disableDeprecatedForms(),
  provideForms(),
  APP_ROUTER_PROVIDERS,
  MdIconRegistry,
  {
    provide: APP_BASE_HREF,
    useValue: '<%= APP_BASE %>'
  }
]);

// In order to start the Service Worker located at "./worker.js"
// uncomment this line. More about Service Workers here
// https://developer.mozilla.org/en-US/docs/Web/API/Service_Worker_API/Using_Service_Workers
//
// if ('serviceWorker' in navigator) {
//   (<any>navigator).serviceWorker.register('./worker.js').then((registration: any) =>
//       console.log('ServiceWorker registration successful with scope: ', registration.scope))
//     .catch((err: any) =>
//       console.log('ServiceWorker registration failed: ', err));
// }
