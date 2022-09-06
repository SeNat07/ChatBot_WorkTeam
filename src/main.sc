require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Привет! Я чат-бот, который поможет тебе понять, кто ты из команды OCR. Приступим!
        go!: /Lets go

    state: Lets go
        buttons:
            "Начать" -> /Question_1
    
    state: Question_1
        a: Ты девушка или мужчина?
        buttons:
            "Девушка" -> /Question_w2      
            "Мужчина" -> /
    
    state: Question_w2
        a: Ты знаешь ABBYY на 10/10?
        buttons:
            "Да" -> /Question_w31
            "Нет" -> /Question_w32
            
    state: Question_w31
        a: Ты изучаешь React?
        buttons:
            "Да" -> /Rezult_Nastya
            "Нет" -> /Question_w32        
    
    state: Question_w32
        a: Ты знаешь больше 20 настольных игр?
        buttons:
            "Да" -> /Question_w41
            "Нет" -> /Question_w42              
    
    state: Question_w41
        a: У тебя есть винтовка?
        buttons:
            "Да" -> /Rezult_Natasha
            "Нет" -> /Question_w42          
            
    state: Question_w42
        a: Ты делала проект на 1С?
        buttons:
            "Да" -> /Rezult_Liza
            "Нет" -> /Question_w2         
            
            
            
            
            
            
            
    state: Rezult_Nastya
        a: Я угадал! Ты - Настя!  
    
    state: Rezult_Natasha
        a: Я угадал! Ты - Наташа!
        
    state: Rezult_Liza
        a: Я угадал! Ты - Лиза!

    state: Bye
        intent!: /пока
        a: Пока пока

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}