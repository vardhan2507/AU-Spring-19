import { Directive,  TemplateRef, ViewContainerRef, Input } from '@angular/core';
import { strictEqual } from 'assert';
import { stringify } from '@angular/compiler/src/util';

@Directive({
  selector: '[appSampleDirective]'
})
export class SampleDirectiveDirective{

  private hasView = false;
  

  constructor(
    private templateRef: TemplateRef<any>,
    private viewContainer: ViewContainerRef) { }

  @Input() set appSampleDirective(condition: boolean) {
   this. changeText();
    if (!condition && !this.hasView) {
      this.viewContainer.createEmbeddedView(this.templateRef);
      this.hasView = true;
    } else if (condition && this.hasView) {
      this.viewContainer.clear();
      this.hasView = false;
    }

    }

    @Input() 
    str:string;

    changeText(){

    this.templateRef.elementRef.nativeElement.innerHTML="I changed";

    }


  }

