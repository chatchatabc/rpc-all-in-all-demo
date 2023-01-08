import {createTRPCProxyClient, httpLink,} from '@trpc/client';
import AbortController from 'abort-controller';
import fetch from 'node-fetch';
import type {AppRouter} from './router';

// polyfill fetch & websocket
const globalAny = global as any;
globalAny.AbortController = AbortController;
globalAny.fetch = fetch;

//create trpc client
const trpc = createTRPCProxyClient<AppRouter>({
    links: [
       /* httpLink({
            url: `http://localhost:2022`,
        }),*/
        httpLink({
            url: `http://localhost:8080`,
        })
    ],
});

async function main() {
    // call hello query procedure
    const helloResponse = await trpc.greeting.hello.query({
        name: 'world',
    });
    console.log('helloResponse', helloResponse);
    //call hello2 query procedure
    const hello2Response = await trpc.greeting.hello2.query('linux_china');
    console.log('hello2Response', hello2Response);
    // call createPost mutate procedure
    const createPostRes = await trpc.poster.createPost.mutate({
        title: 'hello world',
        text: 'check out https://tRPC.io',
    });
    console.log('createPostResponse', createPostRes);
}

main().then();
