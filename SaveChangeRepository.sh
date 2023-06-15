!#/bin/bash
git status
sleep 5
git add .
sleep 5
read -p "Ingrese el mensaje: " msj
git commit -m  " $( msj ) "
sleep 5
git push origin main
echo "Subido al repositorio con exito"

