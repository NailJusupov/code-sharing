FROM node:12.8.0-alpine AS builder
COPY . ./angular
WORKDIR /angular
RUN npm i && $(npm bin)/ng build --prod
FROM nginx:1.17.3-alpine
COPY --from=builder /angular/dist/angular /usr/share/nginx/html
RUN ls -la /usr/share/nginx/html
