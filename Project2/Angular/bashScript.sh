ng build --prod --deploy-url "Ticketopia/" --base-href "Ticketopia/"


rm -f ../Maven/src/main/webapp/*
mv ./dist/Angular/* ../Maven/src/main/webapp/
