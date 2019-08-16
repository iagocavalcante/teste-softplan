# FROM node:8.9.0 as node

# RUN mkdir -p /softplan-front

# WORKDIR /softplan-front

# COPY package.json /softplan-front

# RUN npm install

# COPY . /softplan-front

# EXPOSE 3000

# RUN npm run build

# FROM nginx:1.13.7-alpine

# COPY --from=node /softplan-front/dist/ /usr/share/nginx/html
FROM node:8.16.1 as node

RUN mkdir -p /softplan-front

WORKDIR /softplan-front

COPY package.json /softplan-front

RUN npm install

COPY . /softplan-front

EXPOSE 80

RUN npm run build

FROM nginx

RUN nginx -v

COPY --from=node /softplan-front/dist/ /usr/share/nginx/html

# COPY ./nginx-softplan-front.conf /etc/nginx/conf.d/default.conf

COPY ./nginx-softplan-front.conf /etc/nginx/nginx.conf

COPY ./default.conf /etc/nginx/conf.d/default.conf

RUN chmod 0755 ./usr/share/nginx/html