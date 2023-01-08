import {createHTTPServer} from '@trpc/server/adapters/standalone';
import {appRouter} from './router';

// create http server
const {server, listen} = createHTTPServer({
    router: appRouter,
});
// start listen
listen(2022);
