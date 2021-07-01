package com.example.justdoit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.example.justdoit.adapters.AdaptadorDicas;
import com.example.justdoit.model.DicaModel;

import java.util.ArrayList;
import java.util.Arrays;

public class TelaInicialActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.activity_tela_inicial, null, false);
        drawerLayout.addView(v,0);

        ListView listView = findViewById(R.id.listaDicas);
        ArrayList<DicaModel> dicaModels = todasDicasVidaSaudavel();
        listView.setAdapter(new AdaptadorDicas(this, dicaModels));
    }

    private ArrayList<DicaModel> todasDicasVidaSaudavel(){
        return new ArrayList<>(Arrays.asList(
           new DicaModel("Inclua castanhas na rotina alimentar", R.drawable.castanhas ,"\"Castanhas-do-pará, de caju, nozes e amêndoas possui baixo índice glicêmico, o que significa que não alteram os níveis de insulina no sangue e provocam sensação de saciedade. Também são fontes ricas em fibras, ferro, vitamina E e selênio, mineral importante para o bom funcionamento da tireoide\", diz a a nutróloga Liliane Oppermann. Para aproveitar tudo que as castanhas têm de bom, sem exagerar nas calorias, Liliane recomenda a ingestão de 2 castanhas-do-pará, 3 castanhas de caju, 2 nozes ou 5 amêndoas (escolha apenas uma das opções).", "Confira receita de creme de castanha de caju com shitake trufado\n" +
                   "\n", "http://www.cerratinga.org.br/receita-creme-de-castanha-de-caju-com-shitake-trufado/"),
           new DicaModel("Reduza a ingestão de sal e aumente o consumo de água", R.drawable.agua, "Além de favorecer o inchaço de pernas, pés, barriga e outras regiões do corpo, o excesso de sal pode comprometer a saúde. \"A retenção de líquidos provocada pelo consumo exagerado de sal sobrecarrega o coração, rins e vasos sanguíneos e também pode levar à hipertensão\", explica a médica Liliane Oppermann. A nutróloga recomenda a ingestão de 2 litros de água. Leite, água de coco e sucos podem ajudar a alcançar esse patamar, mas o ideal é que a água pura seja a principal fonte.", "Retenção de líquidos: saiba como evitar o problema", "https://www.tuasaude.com/retencao-de-liquidos-o-que-fazer/"),
            new DicaModel("Não pule o café da manhã", R.drawable.cafedamanha, "O café da manhã diário é necessário para nutrir o organismo. \"É o momento em que o corpo está ávido por nutrientes, já que passou 7 ou 8 horas em jejum, durante o sono. O organismo precisa de energia para começar o dia, além de vitaminas e sais minerais. Se uma pessoa comer fruta no café da manhã, seus nutrientes serão mais bem aproveitados do que antes de dormir\", orienta a nutróloga Liliane Oppermann. Um café da manhã saudável evita o consumo de calorias extras ao longo do dia. Sem a primeira refeição, o organismo passará a manhã sem energia e a fome também virá com mais intensidade ao longo da tarde.", "Confira dicas para deixar o café da manhã mais gostoso", "https://catracalivre.com.br/saude-bem-estar/7-dicas-para-um-cafe-da-manha-mais-rapido-saudavel-e-gostoso/"),
            new DicaModel("Pratique exercícios físicos regularmente", R.drawable.mulherseexercitando,"Os exercícios físicos devem fazer parte da rotina, inclusive, de quem não precisa perder peso. Uma simples caminhada diária pode melhorar o humor e afastar doenças do coração. De acordo com cardiologista Rogério de Moura, coordenador do serviço de cardiologia do Hospital Balbino, \"para proteger o coração, o ideal é praticar exercícios durante 45 minutos a 1 hora, 5 vezes por semana\". Para quem não gosta de academia, o médico recomenda caminhar pelo quarteirão, na praia ou em parques verdes. Outra opção é buscar aulas que fujam do convencional.", "Suspension Cores: saiba mais sobre a aula que queima 500 calorias", "https://gnt.globo.com/bem-estar/noticia/suspension-core-saiba-mais-sobre-a-aula-que-queima-ate-500-calorias.ghtml")
        ));
    }
}