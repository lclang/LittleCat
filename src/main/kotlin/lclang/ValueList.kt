package lclang

class ValueList: ArrayList<Value>(){
    override fun toString(): String {
        var str = ""
        for((i, el) in this.withIndex()){
            str += el.get().toString() + if(this.size != i+1) ", " else ""
        }

        return "[$str]"
    }

    operator fun plus(a: ValueList): ValueList {
        for(el in a) this.add(el);
        return this;
    }
}