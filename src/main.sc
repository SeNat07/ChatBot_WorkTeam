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
            "Мужчина" -> /Question_m2
    
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
            
    state: Question_m2
        a: Ты скоро уходишь в отпуск?
        buttons:
            "Да" -> /Question_m31
            "Нет" -> /Question_m32
            
    state: Question_m31
        a: Ты часто выезжаешь на выходных на природу?
        buttons:
            "Да" -> /Rezult_AlexA
            "Нет" -> /Question_m32        
    
    state: Question_m32
        a: Ты катался на "яхте" о Волге?
        buttons:
            "Да" -> /Question_m41
            "Нет" -> /Question_m42              
    
    state: Question_m41
        a: У тебя есть айфоны на даче?
        buttons:
            "Да" -> /Rezult_AlexR
            "Нет" -> /Question_m42          
            
    state: Question_m42
        a: Тебя зовут Андрей?
        buttons:
            "Да" -> /Question_m51
            "Нет" -> /Question_m32         

    state: Question_m51
        a: У тебя есть борода?
        buttons:
            "Да" -> /Rezult_AndreyA
            "Нет" -> /Rezult_AndreyK            
            
    state: Rezult_Nastya
        a: Я угадал! Ты - Настя Фролова!  
        go!: /Return
    
    state: Rezult_Natasha
        a: Я угадал! Ты - Наташа Седых!
        go!: /Return
        
    state: Rezult_Liza
        a: Я угадал! Ты - Лиза Воронкова!
        go!: /Return

    state: Rezult_AlexA
        a: Я угадал! Ты - Лёша Иванов!
        go!: /Return
        
    state: Rezult_AlexR
        a: Я угадал! Ты - Лёша Рябов!
        go!: /Return
        
    state: Rezult_AndreyA
        a: Я угадал! Ты - Андрей Афанасьев!
        go!: /Return
        
    state: Rezult_AndreyK
        a: Я угадал! Ты - Андрей Кац!
        go!: /Return

    state: Return
        a: Хочешь попробовать ещё раз?
        
        state: ReturnYes
            q!: *(да/ага/*давай*/ещ*)*
            go!: /Question_1
        
        state: ReturnNo
            q!: *(не*)*
            go!: /Bye
        
    state: Bye
        intent!: /пока
        a: Пока, мой милый друг

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}