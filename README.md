# Surfwear micro-service

Cette application est un micro-service qui permet de gérer les produits d'une boutique de surfwear en faisant le lien
entre la logistique, les magasins, la direction et le marketing.
Ce micro-service est développé en Java avec le framework Spring Boot et utilise une base de données PostgreSQL.

# Déploiement

## Docker compose

En utilisant docker compose, vous pouvez facilement déployer ce service en excutant la commande suivante :

```Bash
docker compose --build 
docker coppose up -d
```

## Using Package (Github)

You can find a ready-to-be-deployed package
here : https://github.com/UPPA-s-University-Projects/M2-InteropSI-2023-Surfwear

Just run the following command :
```Bash
docker pull ghcr.io/uppa-s-university-projects/m2-interopsi-2023-surfwear:sha256-387bf94efecda6c980193659edd23d75b08a57ad735036151ba1105a49f9af00.sig
```
