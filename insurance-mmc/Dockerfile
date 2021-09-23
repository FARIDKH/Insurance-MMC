#### Stage 1: Build the angular application
FROM node:latest as build
 
WORKDIR /app

COPY package*.json /app/

RUN npm install

COPY ./ /app/

ARG configuration=production

RUN npm run build -- --output-path=./dist/out --configuration $configuration

FROM nginx:1.15



COPY --from=build /app/dist/out/ /usr/share/nginx/html


COPY  ./nginx.conf /etc/nginx/conf.d/default.conf
