// Leer un archivo imagen PPM desde archivo y almacenarlo en otro archivo
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include <math.h>

struct imagenppm{
	int altura;
	int ancho;
	char *comentario;
	int maxcolor;
	int P;
	int **R;
	int **G;
	int **B;
};
typedef struct imagenppm* imagen;

void GuardarArchivo(imagen I, char * nombre);
imagen CrearImagen(char comentario[], int ancho, int altura, int R, int G, int B, int maxColor);
imagen leerImagen(char * nombre);

imagen CrearImagen(char *comentario, int ancho, int altura, int R, int G, int B, int maxColor){
	int i,j;	
	
	/*Reservó memoria para la estructura Imagen*/
	imagen image=(imagen) malloc(sizeof(struct imagenppm));

	/*Se asignas los valores de comentario, ancho, alto, numero magico
	y el maximo color*/
	image->P=3;
	image->comentario=calloc(strlen(comentario),sizeof(char));
        strcpy(image->comentario,comentario);
	image->ancho=ancho;
	image->altura=altura;
	image->maxcolor=maxColor;

	/*Se reserva la memoria en R, G y B de acuerdo al ancho y altura */
	/*Y se asignan los valores de R,G y B dados, el mismo para cada
	pixel*/
	image->R=malloc(image->ancho*sizeof(int *));
	image->G=malloc(image->ancho*sizeof(int *));
	image->B=malloc(image->ancho*sizeof(int *));
	for(i=0; i<image->ancho; i++)
	{
		image->R[i]=malloc(image->altura*sizeof(int));
		image->G[i]=malloc(image->altura*sizeof(int));
		image->B[i]=malloc(image->altura*sizeof(int));
		for(j=0; j<image->altura; j++){
			image->R[i][j]=R;
			image->G[i][j]=G;
			image->B[i][j]=B;
		}
	}
	
	return image;
}

imagen leerImagen(char * nombre){
	FILE *fp;
	char c;	
	char comentario[300];
	int i=0, j;	
	/*Reservó memoria para la estructura Imagen*/
        imagen I=(imagen) malloc(sizeof(struct imagenppm));

	/*Se habre el fichero ppm*/
	fp=fopen(nombre,"r");
	if(!fp){
		printf("No existe el fichero: Verificar el nombre.\n");
		I->P=-1;
	}
	else{
		/*Se lee y guarda el numero magico*/
		fscanf(fp,"%c%d ",&c,&(I->P));
		/*Se lee y fuarda el comentario caracter por caracter*/
		while((c=fgetc(fp))!= '\n'){comentario[i]=c;i++;}
		I->comentario = calloc(strlen(comentario),sizeof(char));
		strcpy(I->comentario,comentario);
		/*Se lee y guarda el ancho, alto y maximo color*/
		fscanf(fp,"%d %d %d",&I->ancho,&I->altura,&I->maxcolor);
		/*Se reserva la memoria en R, G y B de acuerdo al ancho y
		altura */
		/*Y se asignan los valores de R,G y B del fichero*/
		I->R=calloc(I->ancho,sizeof(int *));
		I->G=calloc(I->ancho,sizeof(int *));
		I->B=calloc(I->ancho,sizeof(int *));

		for(i=0;i<I->ancho;i++){
			I->R[i]=calloc(I->altura,sizeof(int));
			I->G[i]=calloc(I->altura,sizeof(int));
			I->B[i]=calloc(I->altura,sizeof(int));
			for(j=0;j<I->altura;j++){
				fscanf(fp,"%d %d %d ",&I->R[i][j],&I->G[i][j],&I->B[i][j]);
			}
		}
		fclose(fp);
	}
    return I;
}

void GuardarArchivo(imagen I, char * nombre){
	int i,j;
	char nb[1000];
	sprintf(nb,"%s%s",nombre,".ppm");
	FILE *fp;
	/*Se crea el fichero nuevo*/	
	fp=fopen(nb,"w");
	/*Se escribe en el fichero el numero magico, el comentario, el
	ancho, el alto y el maximo color*/
	fprintf(fp,"P%d\n%s\n%d %d\n%d\n",I->P,I->comentario,I->ancho,I->altura,I->maxcolor);
	/*Se escriben los pixeles*/
	for(i=0;i<I->ancho;i++){
		for(j=0;j<I->altura;j++){
			fprintf(fp,"%d %d %d ",I->R[i][j],I->G[i][j],I->B[i][j]);
		}
        	fprintf(fp,"\n");
	}
    fclose(fp);
}

void main(){
	int i,j;
	int opcion;
	char comentario[1000], nombre[1000];
	int ancho,altura,R,G,B,maxcolor;
	imagen image=NULL;
	/*menu*/
	printf("¿Que quieres hacer?\n");
	printf("1) Crear una nueva imagen\n");
	printf("2) Leer una imagen ya existente\n");
	printf("opcion ");
	scanf("%d",&opcion);
	/*crear una imagen*/
	if(opcion==1)
	{
		printf("dame el comentario de la imagen. =>Que comience con el simbolo #, y poner guines bajos en vez de espacios<=\n");
		scanf("%s",comentario);
		printf("Dame el ancho\n");
		scanf("%d",&ancho);
		printf("Dame el altura\n");
		scanf("%d",&altura);
		printf("Dame el maximo color\n");
		scanf("%d",&maxcolor);
		printf("Dame los colores, ques sean menores o iguales al maximo color.\nDame el color Rojo\n");
		scanf("%d",&R);
		printf("Dame el color Verde\n");
		scanf("%d",&G);
		printf("Dame el color Azul\n");
		scanf("%d",&B);
		
		image=CrearImagen(comentario,ancho,altura,R,G,B,maxcolor);
	/*Leer una imagen*/
	} else if(opcion==2)
	{
		printf("Dame el nombre del Archivo con su terminacion ppm\n");
		scanf("%s",nombre);
		image=leerImagen(nombre);
		if(image->P!=3) return;
	} else printf("opcion incorrecta\n");
	
	/*Guardar imagen*/
	if(image->comentario != NULL)
	{
		printf("¿Quieres guadar la imagen?\n");
		printf("1)Si\n");
		printf("2)No\n");
		printf("opcion ");
		scanf("%d",&opcion);

		if(opcion==1)
		{
			printf("Dame el nombre para la imagen\n");
			scanf("%s",nombre);
			GuardarArchivo(image,nombre);
	
		} else if(opcion==2) 
			printf("Adios\n");
		else printf("opcion incorrecta\n");
	}
}
