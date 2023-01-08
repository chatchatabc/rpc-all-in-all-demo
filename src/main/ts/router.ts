import {initTRPC} from '@trpc/server';
import {z} from 'zod';


// This is how you initialize a context for the server

const t = initTRPC.create();

const publicProcedure = t.procedure;
const router = t.router;

const greetingRouter = router({
    hello: publicProcedure
        .input(
            z.object({
                name: z.string(),
            }),
        )
        .query(({input}) => `Hello, ${input.name}!`),
    hello2: publicProcedure
        .input(z.string())
        .query(({input}) => `Hello, ${input}!`),
});

const posterRouter = router({
    createPost: publicProcedure
        .input(
            z.object({
                title: z.string(),
                text: z.string(),
            }),
        )
        .mutation(({input}) => {
            // imagine db call here
            return {
                id: `${Math.random()}`,
                ...input,
            };
        })
});

// Merge routers together
export const appRouter = router({
    greeting: greetingRouter,
    poster: posterRouter,
});

export type AppRouter = typeof appRouter;
