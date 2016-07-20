import {join} from 'path';
import {SeedConfig} from './seed.config';
import {InjectableDependency} from './seed.config.interfaces';
import * as chalk from 'chalk';
import * as util from 'gulp-util';

const proxy = require('http-proxy-middleware');

export class ProjectConfig extends SeedConfig {
  PROJECT_TASKS_DIR = join(process.cwd(), this.TOOLS_DIR, 'tasks', 'project');

  constructor() {
    super();
    this.APP_TITLE = 'Comuni 1.0';
    this.VERSION_NPM = '3.3.6';
    this.VERSION_NODE = '5.0.0';

    let additional_deps: InjectableDependency[] = [
      // {src: 'jquery/dist/jquery.min.js', inject: 'libs'},
      // {src: 'lodash/lodash.min.js', inject: 'libs'},
      { src: '@angular2-material/button/button.js', inject: 'libs' },
      { src: '@angular2-material/button/button.css', inject: true },
      { src: '@angular2-material/card/card.js', inject: 'libs' },
      { src: '@angular2-material/card/card.css', inject: true },
      { src: '@angular2-material/checkbox/checkbox.js', inject: 'libs' },
      { src: '@angular2-material/checkbox/checkbox.css', inject: true },
      { src: '@angular2-material/input/input.js', inject: 'libs' },
      { src: '@angular2-material/input/input.css', inject: true },
      { src: '@angular2-material/list/list.js', inject: 'libs' },
      { src: '@angular2-material/list/list.css', inject: true },
      { src: '@angular2-material/progress-circle/progress-circle.js', inject: 'libs' },
      { src: '@angular2-material/progress-circle/progress-circle.css', inject: true },
      { src: '@angular2-material/progress-bar/progress-bar.js', inject: 'libs' },
      { src: '@angular2-material/progress-bar/progress-bar.css', inject: true },
      { src: '@angular2-material/radio/radio.js', inject: 'libs' },
      { src: '@angular2-material/radio/radio.css', inject: true },
      { src: '@angular2-material/sidenav/sidenav.js', inject: 'libs' },
      { src: '@angular2-material/sidenav/sidenav.css', inject: true },
      { src: '@angular2-material/toolbar/toolbar.js', inject: 'libs' },
      { src: '@angular2-material/toolbar/toolbar.css', inject: true }
    ];

    const seedDependencies = this.NPM_DEPENDENCIES;

    this.NPM_DEPENDENCIES = seedDependencies.concat(additional_deps);

    util.log('Proxy ', chalk.red('http://localhost:'+this.PORT+'/comuni-conversations -> http://localhost:8080/comuni-conversations'));

    this.BROWSER_SYNC_CONFIG = {
      middleware: [
        proxy('/comuni-conversations', {target: 'http://localhost:8080/comuni-conversations'}),
        require('connect-history-api-fallback')({index: `${this.APP_BASE}index.html`})
      ],
      port: this.PORT,
      startPath: this.APP_BASE,
      server: {
        baseDir: `${this.DIST_DIR}/empty/`,
        routes: {
          [`${this.APP_BASE}${this.APP_DEST}`]: this.APP_DEST,
          [`${this.APP_BASE}node_modules`]: 'node_modules',
          [`${this.APP_BASE.replace(/\/$/,'')}`]: this.APP_DEST
        }
      }
    };
  }
}
