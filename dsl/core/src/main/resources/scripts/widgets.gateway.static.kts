import com.sun.jmx.snmp.SnmpStatusException.readOnly



val context = bindings["context"] as SpecContext
spec(context) {

    page("REGISTRATION") {
        println(context.x)
        widgets = listOf("w1")
    }

    page("LOGIN") {
        println(context.y)
        if (context.y  == 5) {
            widgets = listOf("ERROR")
        } else {
            widgets = listOf("LOGIN")
        }
    }

    widget("LOGIN") {
        println(context.extra)
        showPredicates = listOf("p1")
        read {
            readOnly = listOf("r1")
            initActions = listOf("i1")
        }
        write {
            fields = listOf("login", "password", "remember")
            jsonValidators = listOf("loginValidator.json")
            validators = listOf("cusvalid")
            completeActions = listOf("compAcion")
        }
    }
}



