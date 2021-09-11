const quiz = [
    {
        question: 'マリオシリーズに出てくるピーチ姫の付き人は次のうち誰でしょうか？',
        answers: [
            'ルイージ',
            'クッパ',
            'ジーノ',
            'キノピオ'
        ],
        correct: 'キノピオ'

    }, {
        question: 'FF7Rでまだ出てきていない仲間キャラクターは次のうちどれ？',
        answers: [
            'バレット',
            'ヴィンセント',
            'エアリス',
            'ティファ'
        ],
        correct: 'ヴィンセント'

    }, {
        question: 'モンスターハンターで最後にPSPで発売されたタイトルは次のうちどれ？',
        answers: [
            'ダブルクロス',
            '4',
            'セカンド',
            'サード'
        ],
        correct: 'サード'

    }, {
        question: '次のうち、コナミで発売されていないタイトルはどれ？',
        answers: [
            'ボンバーマン',
            'がんばれ！ゴエモン',
            'メタルギアソリッド',
            '実況！！パワフルプロ野球'
        ],
        correct: 'ボンバーマン'

    },
];

const quizLength = quiz.length;
let quizIndex = 0;
let score = 0;


const $button = document.getElementsByTagName('button');
const buttonLength = $button.length;
//クイズの問題文、選択肢を定義 
const setupQuiz = () =>{
    document.getElementById('js-question').textContent = quiz[quizIndex].question;
    for(let buttonIndex = 0; buttonIndex < buttonLength; buttonIndex++){
        $button[buttonIndex].textContent = quiz[quizIndex].answers[buttonIndex];
    
 }
}
setupQuiz();

const clickHandler = (e) => {
    if(quiz[quizIndex].correct === e.target.textContent){
        window.alert('正解！！');
        score++;
    }else{
        window.alert('不正解・・・');
    }

    quizIndex++;

    if(quizIndex < quizLength){
        //問題数があればこちらを実行
        setupQuiz();
    }else{
        //問題数が無ければこちらを実行
        window.alert('終了～あなたのスコアは' + quizLength + '問中' + score + '問でした！');
    }
};


//ボタンをクリックしたら正誤判断

for(let handleIndex = 0; handleIndex < buttonLength; handleIndex++){
    $button[handleIndex].addEventListener('click', (e) => {
        clickHandler(e);
    });
}
