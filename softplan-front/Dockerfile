FROM node:16 as node

RUN mkdir -p /softplan-front

WORKDIR /softplan-front

COPY package.json /softplan-front

RUN yarn

COPY . /softplan-front

EXPOSE 80

RUN yarn build

FROM nginx

RUN nginx -v

COPY --from=node /softplan-front/dist/ /usr/share/nginx/html

COPY ./nginx-softplan-front.conf /etc/nginx/nginx.conf

COPY ./default.conf /etc/nginx/conf.d/default.conf

RUN chmod 0755 ./usr/share/nginx/html