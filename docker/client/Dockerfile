FROM node AS build

WORKDIR /app
ADD ./reactapp /app

RUN npm install
RUN npm run build

FROM nginx:stable

COPY --from=build /app/build /usr/share/nginx/html
COPY ./nginx.conf /etc/nginx/conf.d/default.conf

