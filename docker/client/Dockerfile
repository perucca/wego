FROM node AS build

WORKDIR /app
ADD ./reactapp .

RUN npm build

FROM nginx:stable

COPY — from=build /reactapp/build/ /var/www
COPY ./nginx.conf /etc/nginx/conf.d/default.conf

CMD ["nginx -g 'daemon off;'"]