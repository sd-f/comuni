import {PORT, APP_DEST, APP_BASE, DIST_DIR} from '../../config';
import * as browserSync from 'browser-sync';
import * as util from 'gulp-util';
import * as chalk from 'chalk';

const proxy = require('proxy-middleware');

let runServer = () => {
  let baseDir = APP_DEST;
  let routes:any = {
    [`${APP_BASE}${APP_DEST}`]: APP_DEST,
    [`${APP_BASE}node_modules`]: 'node_modules',
  };

  if (APP_BASE !== '/') {
    routes[`${APP_BASE}`] = APP_DEST;
    baseDir = `${DIST_DIR}/empty/`;
  }
  /**
  browserSync.init({
    middleware: [require('connect-history-api-fallback')({index: `${APP_BASE}index.html`})],
    port: PORT,
    startPath: APP_BASE,
    server: {
      baseDir: baseDir,
      routes: routes
    }
  });
  */

  util.log('Proxy ', chalk.yellow('/comuni-conversations/ -> http://localhost:8021'));

  browserSync.init({
    port: PORT,
    startPath: APP_BASE,
    server: {
      baseDir: baseDir,
      middleware: [
        proxy({
          protocol: 'http:',
          hostname: 'localhost',
          port: 8021,
          pathname: '/',
          route: '/comuni-conversations',
        }),
        require('connect-history-api-fallback')({index: `${APP_BASE}index.html`})
      ],
      routes: routes
    }
  });
};

let listen = () => {
  // if (ENABLE_HOT_LOADING) {
  //   ng2HotLoader.listen({
  //     port: HOT_LOADER_PORT,
  //     processPath: file => {
  //       return file.replace(join(PROJECT_ROOT, APP_SRC), join('dist', 'dev'));
  //     }
  //   });
  // }
  runServer();
};

let changed = (files: any) => {
  if (!(files instanceof Array)) {
    files = [files];
  }
  // if (ENABLE_HOT_LOADING) {
  //   ng2HotLoader.onChange(files);
  // } else {
  //TODO: Figure out why you can't pass a file to reload
  browserSync.reload(files.path);
  //}
};

export { listen, changed };
