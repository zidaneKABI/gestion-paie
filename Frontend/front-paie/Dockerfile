# Étape 1 : Build Angular avec Node.js
FROM node:19 AS build

WORKDIR /app
COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build --prod

# Étape 2 : Servir le frontend avec Nginx
FROM nginx:alpine

# Copier les fichiers compilés Angular dans le répertoire Nginx
COPY --from=build /app/dist/front-paie/browser /usr/share/nginx/html

# Config personnalisée pour Angular (routes SPA)
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
